SlidingMenu
=======
SlidingMenu is an Open Source Android library that allows developers to easily create applications with sliding menus like those made popular in the Google+, YouTube, and Facebook apps.

ScreenShot
--------
 ![sample](./screenshot/sample.gif)

### Simple Example

```java
public class BaseActivity extends SlidingFragmentActivity {

    private int mTitleRes;
    protected ListFragment mFrag;

    public BaseActivity(int titleRes) {
        mTitleRes = titleRes;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(mTitleRes);

        // set the Behind View
        setBehindContentView(R.layout.menu_frame);
        if (savedInstanceState == null) {
            FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
            mFrag = new SampleListFragment();
            t.replace(R.id.menu_frame, mFrag);
            t.commit();
        } else {
            mFrag = (ListFragment) this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
        }

        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
        sm.setAboveFadeEnabled(true);
        sm.setAboveFadeDegree(0.35f);
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setBehindFadeEnabled(false);
        sm.setBehindFadeDegree(0.35f);
        sm.setTouchModeAbove(SlidingMenu.TOUCH_MODE_FULLSCREEN);
        sm.setTouchModeBehind(SlidingMenu.TOUCH_MODE_FULLSCREEN);
    }

}
```

DownLoad
--------
```groovy
compile 'com.github.ShortStickBoy:SlidingMenu:V1.0.0'
```

License
=======

    Copyright 2017 sunzn

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.