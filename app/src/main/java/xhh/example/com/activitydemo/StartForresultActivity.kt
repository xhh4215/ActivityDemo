package xhh.example.com.activitydemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start_forresult.*

class StartForresultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_forresult)
        button.setOnClickListener {
            val message = intent.getStringExtra("startactivity_forresult")
            val mymessage = message + "这是你发送的数据是吧"
            intent.putExtra("result", mymessage)
            /***
             * setResult()
             *  param1 这是一个标识当前的activity身份的整数值
             *  param2 这是一个包含返回的数据的参数
             *  */
            setResult(10, intent)
            this@StartForresultActivity.finish()

        }


    }
}
