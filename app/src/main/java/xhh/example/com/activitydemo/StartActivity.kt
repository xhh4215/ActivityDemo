package xhh.example.com.activitydemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val message = intent.getStringExtra("startactivity")
        Toast.makeText(this@StartActivity, message, Toast.LENGTH_LONG).show()
    }
}
