package ziedkhmiri.customzodiac;



/**
 * Created by zied216 on 19/04/2017.
 */

public class img  {

    public int mDrawable;
   public String mName;
   public String mDate;

   public img(String name, int drawable, String date) {
       this.mName = name;
        this.mDrawable = drawable;
        this.mDate = date;
    }




    public String getDate() {
        return mDate;
    }

    public int getDrawable() {
        return mDrawable;
    }

    public String getName() {
        return mName;
    }



}
