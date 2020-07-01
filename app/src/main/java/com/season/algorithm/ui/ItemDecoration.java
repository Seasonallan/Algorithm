package com.season.algorithm.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecoration extends RecyclerView.ItemDecoration {


    //头部的高
    private int mItemHeaderHeight;
    private int mTextPaddingLeft;

    //画笔，绘制头部和分割线
    private Paint mItemHeaderPaint;
    private Paint mTextPaint;
    private Paint mLinePaint;

    private Rect mTextRect;
    public ItemDecoration(){
        mItemHeaderHeight = 128;
        mTextPaddingLeft = 8;

        mTextRect = new Rect();

        mItemHeaderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mItemHeaderPaint.setColor(Color.GRAY);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(46);
        mTextPaint.setColor(Color.WHITE);

        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setColor(Color.GRAY);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getAdapter() instanceof MainAdapter) {
            MainAdapter adapter = (MainAdapter) parent.getAdapter();
            int count = parent.getChildCount();
            for (int i = 0; i < count; i++) {
                View view = parent.getChildAt(i);
                int position = parent.getChildLayoutPosition(view);
                boolean isHeader = adapter.isItemHeader(position);
                if (isHeader) {
                    c.drawRect(0, view.getTop() - mItemHeaderHeight, parent.getWidth(), view.getTop(), mItemHeaderPaint);
                    mTextPaint.getTextBounds(adapter.getGroupName(position), 0, adapter.getGroupName(position).length(), mTextRect);
                    c.drawText(adapter.getGroupName(position), 8, (view.getTop() - mItemHeaderHeight) + mItemHeaderHeight / 2 + mTextRect.height() / 2, mTextPaint);
                } else {
                    c.drawRect(0, view.getTop() - 1, parent.getWidth(), view.getTop(), mLinePaint);
                }
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getAdapter() instanceof MainAdapter) {
            MainAdapter adapter = (MainAdapter) parent.getAdapter();
            int position = ((LinearLayoutManager) (parent.getLayoutManager())).findFirstVisibleItemPosition();
            View view = parent.findViewHolderForAdapterPosition(position).itemView;
            boolean isHeader = adapter.isItemHeader(position + 1);
            int top = parent.getPaddingTop();
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            if (isHeader) {
                int bottom = Math.min(mItemHeaderHeight, view.getBottom());
                c.drawRect(left, top + view.getTop() - mItemHeaderHeight, right, top + bottom, mItemHeaderPaint);
                mTextPaint.getTextBounds(adapter.getGroupName(position), 0, adapter.getGroupName(position).length(), mTextRect);
                c.drawText(adapter.getGroupName(position), left + mTextPaddingLeft, top + mItemHeaderHeight / 2 + mTextRect.height() / 2 - (mItemHeaderHeight - bottom), mTextPaint);
            } else {
                c.drawRect(left, top, right, top + mItemHeaderHeight, mItemHeaderPaint);
                mTextPaint.getTextBounds(adapter.getGroupName(position), 0, adapter.getGroupName(position).length(), mTextRect);
                c.drawText(adapter.getGroupName(position), left + mTextPaddingLeft, top + mItemHeaderHeight / 2 + mTextRect.height() / 2, mTextPaint);
            }
            c.save();
        }

    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getAdapter() instanceof MainAdapter) {
            MainAdapter adapter = (MainAdapter) parent.getAdapter();
            int position = parent.getChildLayoutPosition(view);
            boolean isHeader = adapter.isItemHeader(position);
            if (isHeader) {
                outRect.top = mItemHeaderHeight;
            } else {
                outRect.top = 1;
            }
        }
    }
}