package xhh.example.com.activitydemo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*
  const  val KEY_STARTACTIVITY:String = "startactivity"
  const  val HEY_STARTACTIVITY_FORRESULT = "startactivity_forresult"
class MainActivity : AppCompatActivity() {
    companion object {
        internal  val PICK_CONTACT_REQUEST = 0
    }
    /***
     * 你必须回调这个方法，但系统首次创建活动的时候触发回调 在创建活动的时候
     * 进入创建的状态 找onCreate() 执行的是基本的应用启动的逻辑，这些逻辑是在
     * actiivty整个生命周期值发生一次
     *
     * 关键词 activity 首次创建
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        id_startactivity.setOnClickListener{
            val intent = Intent(this@MainActivity,StartActivity::class.java)
            val message = id_startactivity.text
            intent.putExtra(KEY_STARTACTIVITY,message)
            startActivity(intent)
        }
        id_startactivity_forresult.setOnClickListener {
            val intent = Intent(this@MainActivity,StartForresultActivity::class.java)
            val message = id_startactivity_forresult.text
            intent.putExtra(HEY_STARTACTIVITY_FORRESULT,message)
            startActivityForResult(intent, PICK_CONTACT_REQUEST)
        }
    }

    /***
     * 在当前的actiivty启动另一个activity的时候
     * 返回的数据的处理的回调的函数
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            PICK_CONTACT_REQUEST->{
                if (resultCode==10){
                    id_startactivity_forresult.text = data?.getStringExtra("result")
                }
            }
        }

    }
    /***
     * 活动进入开始状态的时候回调这个方法 在调用onStart()之后用户就可以看到这个acitvity了
     * 例如，此方法是应用程序初始化维护UI的代码的位置
     *
     * 关键词  activity 变的可见
     *
     */
    override fun onStart() {
        super.onStart()
    }

    /***
     * 活动进入到恢复状态回调的方法 他进入前台 在这里进行的是和用户交互的逻辑
     *
     *
     * 关键词：活动进入前台
     */
    override fun onResume() {
        super.onResume()
    }

    /***
     * 活动进入到暂停的状态时候回调的方法
     * 调用这个方法  之后用户离开当前的活动  它表明当前的窗口不处于前台
     *
     * 关键词：活动不处于前台
     */
    override fun onPause() {
        super.onPause()
    }

    /***
     * 活动进入停止状态的时候回调的方法
     * 当活动不可见的时候 它就会进入停止状态
     */
    override fun onStop() {
        super.onStop()
    }

    /***
     * 活动被销毁的时候回调的方法
     */
    override fun onDestroy() {
        super.onDestroy()
    }
    //  恢复 activity 销毁是保存的数据
      override fun onRestoreInstanceState(savedInstanceState: Bundle?) {

    }

    //   当活动停止的时候会回调这个方法对数据进行处理
    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
    }
}
