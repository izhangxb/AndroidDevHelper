package com.example.zhangxb.androidutils.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.zhangxb.androidutils.R;
import com.example.zhangxb.androidutils.widget.CommonAdapter;
import com.example.zhangxb.androidutils.widget.CommonViewHolder;

import java.util.List;

/**
 * -------------------------------
 * -         ,.                  -
 * -        (_|,.                -
 * -       ,' /, )_______   _    -
 * -    __j o``-'        `.'-)'  -
 * -   (")                 \'    -
 * -    `-j                |     -   神兽保佑，永无BUG
 * -      `-._(           /      -
 * -         |_\  |--^.  /       -
 * -        /_]'|_| /_)_/        -
 * -           /_]'  /_]'        -
 * -------------------------------
 *
 * @Description: .
 * @Date: 2017/4/28.
 * @Author: za-zhangxiaobo.
 */

public class ListChoosePopupWindow extends PopupWindow {

    private CommonAdapter commonAdapter;
    private ListView listView;

    public ListChoosePopupWindow(Context context, List<String> list) {
        super(context);

        commonAdapter = new CommonAdapter<String>(context, list, R.layout.layout_list_item) {
            @Override
            public void convert(CommonViewHolder helper, String item) {
                ((TextView) helper.getView(R.id.tv_item)).setText(item);
            }
        };

        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_window, null);

        listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(commonAdapter);
        setContentView(view);
    }


}
