# AppIntroPager
An Material Library for Intro Your App  In Android :)
It works for api +15 ;) 

<img src="https://github.com/soheil-mohammadi/AppIntroPager/blob/master/app_intro.gif" width="35%"/><img src="https://github.com/soheil-mohammadi/AppIntroPager/blob/master/Screen_Shot.png" width="35%"/>


# HOW TO USE THIS LIBRARY ?!
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency :
```gradle
dependencies {
	        compile 'com.github.soheil-mohammadi:AppIntroPager:1.5.2'
	}
```

# Xml :
```xml
<LinearLayout
    android:id="@+id/container_app_intro"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <kavoshgar1.soheil.com.appintro.IntroAppView
        android:id="@+id/intro_app_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>


</LinearLayout>

```

# MainActivity.Java file :

```java
public class MainActivity extends AppCompatActivity implements onInflateViewAppIntro {

    private  IntroAppView  intro_app_view ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intro_app_view = (IntroAppView) findViewById(R.id.intro_app_view);
        init_intro_appView();
    }


    private void init_intro_appView() {
        ArrayList<Integer> res_layouts = new ArrayList<>() ;
        res_layouts.add(R.layout.intro_app_view_one);
        res_layouts.add(R.layout.intro_app_view_two);
        intro_app_view.setFragmentManager(getSupportFragmentManager()).setResLayouts(res_layouts).build(8 , Color.GREEN);
    }


    @Override
    public void do_someThings(final ViewPager viewPager, View view, int current_page) {

        switch (current_page) {
            case  1 :
                Button btn_app_intro_one = view.findViewById(R.id.btn_app_intro_one);

                btn_app_intro_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewPager.setCurrentItem(1);
                    }
                });
                break;

            case 2 :

                Button btn_app_intro_end = view.findViewById(R.id.btn_app_intro_end);
                btn_app_intro_end.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this , SecondActivity.class));
                        finish();
                    }
                });

                break;
        }

    }


}

```
<b>Review Codes : </b> </br>
In xml file we definde <b>IntroAppView</b> then in MainActivity.java we init it and used <b>init_intro_appView</b> method . </br>
In this method we call <b>setFragmentManager</b> method and pass FragmentManager to it then because of <b>chaining IntroAppView</b> we call <b>setResLayouts</b> method and pass an ArrayList<Integer> of <b>resource layouts</b> ids to it (You should put resorce layout ids that you want show in order in screen device :) ) </br> then is final step we call build method to create and build our AppIntroView . The build method gets two parameters : </br>
param 1 : it needs a fload radius for circles that will be shown inbottom of screen for showing that user is where step :) </br> param 2 : it needs an  custom color for color of circles .


For last and final step : MainActivity should  implements  <b>onInflateViewAppIntro</b> : </br>
so you will override do_someThings method . It gives you ViewPager , View and current_page ! </br>
We definde and init  our views in resource layouts that we definde them and pass it to AppIntroView while initializing .
with current page we do some thing and action ! </br>
For example in page 2 , We start SecondeActivity and finish Introing Our App . 

-------------------------------------------------------------------------------------
##Contact :
You can send your comments for improve this library to me ;) </br>
Email : mad4r20@gmail.com </br>
Telegram : <a href="https://t.me/p_soheil_mohammadi_p">Soheil Mohammadi</a> </br>

-------------------------------------------------------------------------------------
Good Luck :)

