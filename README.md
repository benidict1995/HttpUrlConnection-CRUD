# HttpUrlConnection-CRUD
this is my practice application for Web Services using HttpUrlConnection, I used XAMPP for the local server.

# HttpUrlConnection
An URLConnection for HTTP (RFC 2616) used to send and receive data over the web.Data may be of any type and length. 
This class may be used to send and receive streaming data whose length is not known in advance. 

# Classes
* [MainActivity](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/app/src/main/java/com/example/benidictdulce/httpurlconnection_crud/MainActivity.java)
* [Insert User](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/app/src/main/java/com/example/benidictdulce/httpurlconnection_crud/Insert_User.java)
* [View All User](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/app/src/main/java/com/example/benidictdulce/httpurlconnection_crud/View_All_User.java)
* [View User](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/app/src/main/java/com/example/benidictdulce/httpurlconnection_crud/View_User.java)
* [RequestHandler](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/app/src/main/java/com/example/benidictdulce/httpurlconnection_crud/request/RequestHandler.java)
* [POJO](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/app/src/main/java/com/example/benidictdulce/httpurlconnection_crud/pojo/User.java)
* [Config](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/app/src/main/java/com/example/benidictdulce/httpurlconnection_crud/config/Config.java)
* [Adapter](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/app/src/main/java/com/example/benidictdulce/httpurlconnection_crud/adapter/RecyclerViewAdapter.java)

# PHP Script
* [Connection](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/rest/connection.php)
* [Delete User](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/rest/deleteUser.php)
* [Display User](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/rest/displayUser.php)
* [Get Single User](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/rest/getUser.php)
* [Insert User](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/rest/insertUser.php)
* [Update User](https://github.com/benidict1995/HttpUrlConnection-CRUD/blob/master/rest/updateUser.php)

# Android Support Libraries
 The __RecyclerView__ widget is a more advanced and flexible version of ListView. This widget is a container for displaying large 
 data sets that can be scrolled very efficiently by maintaining a limited number of views. Use the RecyclerView widget when 
 you have data collections whose elements change at runtime based on user action or network events.

__CardView__ extends the FrameLayout class and lets you show information inside cards that have a consistent look across the
platform. CardView widgets can have shadows and rounded corners.

 ## Add this to your project Dependencies

  compile 'com.android.support:design:23.4.0'
  compile 'com.android.support:recyclerview-v7:23.4.0'
  compile 'com.android.support:cardview-v7:23.4.0'
  
  # Resources
  * [Support Library](https://developer.android.com/topic/libraries/support-library/index.html#overview)
  * [Lists and Cards](https://developer.android.com/training/material/lists-cards.html)
