package np.com.naxa.naxa_app

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "naxa"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            CHANNEL
        ).setMethodCallHandler { call, result ->
            if (call.method == "launchODK") {
                Toast.makeText(this, "Triggered", Toast.LENGTH_SHORT).show()

                val intent = Intent()
                val code = "1234567890"
                intent.putExtra("value", code)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

}
