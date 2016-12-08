package com.centennial.project.eatouteatsafe.pojos;

import com.centennial.project.eatouteatsafe.ListRestaurantsActivity;
import com.centennial.project.eatouteatsafe.ReviewListActivity;
import com.centennial.project.eatouteatsafe.ViewRestaurantActivity;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by a_b on 12-10-2016.
 */
public class Utils {
    public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
                int count=is.read(bytes, 0, buffer_size);
                if(count==-1)
                    break;
                os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }

    public static void connectToAPIAndGetJSON(ListRestaurantsActivity listAct, int option, String parameter){
        // start parsing the JSON data
        APIConnection apiConnection = new APIConnection(listAct, option, parameter);
        apiConnection.execute();
    }

    public static void connectToAPIAndGetJSON( ViewRestaurantActivity viewAct, int option, String parameter){
        // start parsing the JSON data
        APIConnection apiConnection = new APIConnection(viewAct, option, parameter);
        apiConnection.execute();
    }

    public static void connectToAPIAndGetJSON(ReviewListActivity reviewAct, int option, String parameter){
        // start parsing the JSON data
        APIConnection apiConnection = new APIConnection(reviewAct, option, parameter);
        apiConnection.execute();
    }
}
