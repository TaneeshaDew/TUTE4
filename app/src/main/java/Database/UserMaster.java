package Database;

import android.provider.BaseColumns;

public final class UserMaster {
    private UserMaster() { }
    protected static   class User implements BaseColumns{

        protected static  final  String TABLE_NAME = "userinfo";
       protected static   final String COLUMN_NAME_USERNAME = "user_name";
       protected static   final String COLUMN_NAME_PASSWORD = "PASSWORD";
    }

}
