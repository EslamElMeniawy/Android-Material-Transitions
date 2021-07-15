package elmeniawy.eslam.materialtransitions

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import elmeniawy.eslam.materialtransitions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        // Setup layout.
        drawUnderStatusNavigationBars()
    }

    /**
     * drawUnderStatusNavigationBars
     *
     * Make the status bar and navigation bar transparent and draw app under them.
     */
    private fun drawUnderStatusNavigationBars() {
        window?.run {
            statusBarColor = Color.TRANSPARENT
            navigationBarColor = Color.TRANSPARENT

            when {
                Build.VERSION.SDK_INT < 30 -> {
                    @Suppress("DEPRECATION")
                    decorView.systemUiVisibility = (
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
                }

                else -> {
                    @Suppress("NewApi")
                    setDecorFitsSystemWindows(false)
                }
            }
        }
    }
}