/*
 * Created by Team 5 on 2021.10.14
 * Copyright © 2021 Team 5. All rights reserved.
 */
package edu.vt.globals;

public final class Constants {
    /*
    ==================================================
    |   Use of Class Variables as Global Constants   |
    ==================================================
    All of the variables in this class are Class Variables (typed with the "static" keyword)
    with Constant values, which can be accessed in any class in the project by specifying
    Constants.CONSTANTNAME, i.e., ClassName.ClassVariableNameInCaps

    Constants are specified in capital letters.
    
    =====================================================
    |   Our Design Decision for Use of External Files   |
    =====================================================
    We decided to use directories external to our application for the storage and retrieval of user's files.
    We do not want to store/retrieve external files into/from our database for the following reasons:
    
        (a) Database storage and retrieval of large files as BLOB (Binary Large OBject) degrades performance.
        (b) BLOBs increase the database complexity.
        (c) The operating system handles the external files instead of the database management system.
    
    WildFly provides an internal web server, named Undertow, to access and display external files.
    See https://docs.wildfly.org/24/Admin_Guide.html#Undertow
     */

    //---------------
    // To run locally
    //---------------

    // Windows
//    public static final String FILES_ABSOLUTE_PATH  = "C:/Users/Balci/DocRoot/CloudStorage/FileStorage/";
//    public static final String PHOTOS_ABSOLUTE_PATH = "C:/Users/Balci/DocRoot/CloudStorage/PhotoStorage/";

    // Unix (macOS) or Linux
//    public static final String FILES_ABSOLUTE_PATH  = "/Users/jack/DocRoot/CS5704-Team5-FileStorage/FileStorage/";
//    public static final String PHOTOS_ABSOLUTE_PATH = "/Users/jack/DocRoot/CS5704-Team5-FileStorage/PhotoStorage/";

    //--------------------------------
    // To run on your AWS EC2 instance
    //--------------------------------
    public static final String FILES_ABSOLUTE_PATH  = "/opt/wildfly/DocRoot/CS5704-Team5-FileStorage/FileStorage/";
    public static final String PHOTOS_ABSOLUTE_PATH = "/opt/wildfly/DocRoot/CS5704-Team5-FileStorage/PhotoStorage/";

    /*
     ---------------------------------
     To Deploy to Your AWS EC2 server:
     ---------------------------------
     STEP 1: Comment out the two constants under "To run locally" above.
     STEP 2: Uncomment the two constants under "To run on your AWS EC2 instance" above.

     STEP 3: Comment out the two constants under "To run locally" below.
     STEP 4: Uncomment the two constants under "To run on your AWS EC2 instance with your IP address" below.
     STEP 5: Replace 54.92.194.218 with the public IP address of your AWS EC2 instance.

     STEP 6: Select Build --> Rebuild Project.
     STEP 7: Run your app to generate the WAR file. Do not use the app locally!
     STEP 8: Use the generated WAR file to deploy your app to your AWS EC2 server.

     STEP 9: Undo the above changes to run the app locally.
     */

    /*
    =================================================================================================
    |   For displaying external files to the user in an XHTML page, we use the Undertow subsystem.  |
    =================================================================================================
     We configured WildFly Undertow subsystem so that
     http://localhost:8080/files/f  displays file f from /Users/Balci/DocRoot/CloudStorage/FileStorage/
     http://localhost:8080/photos/p displays file p from /Users/Balci/DocRoot/CloudStorage/PhotoStorage/
     */

    //---------------
    // To run locally
    //---------------
//    public static final String FILES_URI  = "http://localhost:8080/goodbite_files/";
//    public static final String PHOTOS_URI = "http://localhost:8080/goodbite_photos/";

    //-----------------------------------------------------
    // To run on your AWS EC2 instance with your IP address
    //-----------------------------------------------------
    public static final String FILES_URI  = "https://cs5704gulati.live/goodbite_files/";
    public static final String PHOTOS_URI = "https://cs5704gulati.live/goodbite_photos/";

    /* 
    =============================================
    |   Our Design Decision for Profile Photo   |
    =============================================
    We do not want to use the uploaded user profile photo as is, which may be very large
    degrading performance. We scale it down to size 200x200 called the Thumbnail photo size.
     */
    public static final Integer THUMBNAIL_SIZE = 200;

    /* 
     United States postal state abbreviations (codes)
     */
    public static final String[] STATES = {"AK", "AL", "AR", "AZ", "CA", "CO", "CT",
        "DC", "DE", "FL", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA",
        "MD", "ME", "MH", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM",
        "NV", "NY", "OH", "OK", "OR", "PA", "PR", "PW", "RI", "SC", "SD", "TN", "TX", "UT",
        "VA", "VI", "VT", "WA", "WI", "WV", "WY"};

    /* 
     A security question is selected and answered by the user at the time of account creation.
     The selected question/answer is used as a second level of authentication for
     (a) resetting user's password, and (b) deleting user's account.
     */
    public static final String[] QUESTIONS = {
        "In what city or town did your mother and father meet?",
        "In what city or town were you born?",
        "What did you want to be when you grew up?",
        "What do you remember most from your childhood?",
        "What is the name of the boy or girl that you first kissed?",
        "What is the name of the first school you attended?",
        "What is the name of your favorite childhood friend?",
        "What is the name of your first pet?",
        "What is your mother's maiden name?",
        "What was your favorite place to visit as a child?"
    };

    public static final String GEOAPIFY_BASE_URL = "https://api.geoapify.com/v2/places?categories=commercial.supermarket&filter=circle:";
    public static final String GEOAPIFY_API_KEY = "688f2afc8f1c4a45b76f18bdd8c286bf";
    public static final String EDAMAM_BASE_URL = "https://api.edamam.com/api/recipes/v2?type=public&q=";
    public static final String EDAMAM_APP_ID = "99b8644e";
    public static final String EDAMAM_API_KEY = "f52130770151d0b2a5cada889bf6ab3d";
//    https://api.edamam.com/api/nutrition-data?app_id=764889db&app_key=54fbdd1873720b7dc5c01d4eb508a1a7&nutrition-type=cooking&ingr=100g%20rice
    public static final String EDAMAM_NUTRITION_API_KEY = "54fbdd1873720b7dc5c01d4eb508a1a7";
    public static final String EDAMAM_NUTRITION_APP_ID = "764889db";
    public static final String EDAMAM_NUTRITION_BASE_URL = "https://api.edamam.com/api/nutrition-data?app_id=764889db&app_key=54fbdd1873720b7dc5c01d4eb508a1a7&nutrition-type=cooking&ingr=";



}
