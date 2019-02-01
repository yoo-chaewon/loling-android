package mashup.loling

import android.content.Context
import android.os.Bundle

import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import mashup.loling.Fragment.FriendListFragment

class MainActivity : AppCompatActivity() {

    private var context: Context = this
    var mContainer: PagerContainer? = null
    var pageNum = 10
//    var mainIndicator  = pagerIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment: FriendListFragment = FriendListFragment()
        supportFragmentManager.beginTransaction().add(R.id.frMainFriendList, fragment).commit()
 
        mContainer = findViewById<View>(R.id.pagerContainer) as PagerContainer

//        val pager = mContainer!!.viewPager
        val pager = mContainer!!.viewPager as ViewPager
        val adapter = MainPageAdepter()

        pager.setAdapter(adapter);

        //필요한 경우 또는 호출기는 표시할 추가 페이지가 하나뿐입니다.
        // 최소 몇 페이지 이상 볼 수 있도록 설정
        pager.setOffscreenPageLimit(adapter.getCount());
        //페이지 간의 마진
        pager.setPageMargin(20);

        //If hardware acceleration is enabled, you should also remove
        // clipping on the pager for its children.
        pager.setClipChildren(false);
        indicator(pager.currentItem)

    }

    fun indicator(currentItem: Int) {
        pagerIndicator?.createDotPanel(pageNum, R.drawable.indicator_dot_off, R.drawable
                .indicator_dot_on, currentItem)
    }

    private inner class MainPageAdepter : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
//            val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            if (position == 9) {
                val view2 = layoutInflater.inflate(R.layout.item_main_loling_room2, container,
                        false)
                container.addView(view2)
                return view2
            }
            val view = layoutInflater.inflate(R.layout.item_main_loling_room, container, false)
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {
            return pageNum
        }

    }

}
