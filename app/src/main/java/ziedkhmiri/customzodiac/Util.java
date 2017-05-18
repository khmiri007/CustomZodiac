package ziedkhmiri.customzodiac;

/**
 * Created by zied216 on 30/04/2017.
 */

public class Util {
    public static int getIcon(int position) {
        switch (position) {
            case 0:
                return R.drawable.leo;
            case 1:
                return R.drawable.aquarius;
            case 2:
                return R.drawable.cancer;
            case 3:
                return R.drawable.capricorn;
            case 4:
                return R.drawable.gemini;
            case 5:
                return R.drawable.libra;
            case 6:
                return R.drawable.pisces;
            case 7:
                return R.drawable.aries;
            case 8:
                return R.drawable.sagittarius;
            case 9:
                return R.drawable.taurus;
            case 10:
                return R.drawable.virgo;
            case 11:
                return R.drawable.scorpio;
        }

        return 0;
    }
   public static int gettitle(int position){
        switch (position) {
            case 0:
                return R.string.leo;
            case 1:
                return R.string.aquarius;
            case 2:
                return R.string.cancer;
            case 3:
                return R.string.capricorn;
            case 4:
                return R.string.gemini;
            case 5:
                return R.string.libra;
            case 6:
                return R.string.pisces;
            case 7:
                return R.string.aries;
            case 8:
                return R.string.sagittarius;
            case 9:
                return R.string.taurus;
            case 10:
                return R.string.virgo;
            case 11:
                return R.string.scorpio;
        }

        return 0;
    }
    public static int getdetail(int position){
        switch (position){
            case 0 :
                return R.string.detail_Leo;
            case 1:
                return R.string.detail_Aquarius;
            case 2:
                return R.string.detail_Cancer;
            case 3:
                return R.string.detail_Capricorn;
            case 4:
                return R.string.detail_Gemini;
            case 5:
                return R.string.detail_Libra;
            case 6:
                return R.string.detail_Pisces;
            case 7:
                return R.string.detail_Aries;
            case 8:
                return R.string.detail_Sagittarius;
            case 9:
                return R.string.detail_Taurus;
            case 10:
                return R.string.detail_Virgo;
            case 11:
                return R.string.detail_Scorpio;
        }

        return 0;
    }

}
