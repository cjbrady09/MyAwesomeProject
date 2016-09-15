package css188.drake.myapplication2;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by clayton on 9/12/16.
 */
public class UserAdapter extends BaseAdapter{
    private Context myContext;
    private User[] myUsers;

    public UserAdapter(Context context, User[] users)
    {
        myContext = context;
        myUsers = users;
    }

    @Override
    public int getCount() {
        return myUsers.length;
    }

    @Override
    public Object getItem(int position) {
        return myUsers[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null)
        {
            convertView = LayoutInflater.from(myContext).inflate(R.layout.user_list_item, null);

            holder = new ViewHolder();
            holder.nameView = (TextView) convertView.findViewById(R.id.nameView);
            holder.userCell = (RelativeLayout) convertView.findViewById(R.id.userCell);

            convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();
        }

        User user = myUsers[position];

        holder.nameView.setText(user.getName());

        if(user.getColor().toString().equals("Green"))
        {
          holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.greenColor));
        }

        if(user.getColor().toString().equals("Blue"))
        {
            holder.userCell.setBackgroundColor(ContextCompat.getColor(myContext, R.color.blueColor));
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView nameView;
        RelativeLayout userCell;
    }
}
