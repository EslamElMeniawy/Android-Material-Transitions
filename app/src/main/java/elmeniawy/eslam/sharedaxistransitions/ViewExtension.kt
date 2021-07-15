package elmeniawy.eslam.sharedaxistransitions

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * ViewExtension
 *
 * Created by Eslam El-Meniawy on 15-Jul-2021 10:05 AM.
 */

/**
 * Add window insets listener
 * and use the returned insets to get status and navigation bars heights
 * and use them as padding to avoid application being cut by status and navigation bars.
 *
 * @param topView View to set padding top to.
 * @param bottomView View to set padding bottom to.
 * @param topBottomView View to set padding top and bottom to.
 */
fun View.setInsetsPadding(
    topView: View? = null,
    bottomView: View? = null,
    topBottomView: View? = null
) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, insets ->
        val statusBarsInsets = insets.getInsets(WindowInsetsCompat.Type.statusBars())
        val navigationBarsInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars())
        topView?.setPadding(0, statusBarsInsets.top, 0, 0)
        bottomView?.setPadding(0, 0, 0, navigationBarsInsets.bottom)
        topBottomView?.setPadding(0, statusBarsInsets.top, 0, navigationBarsInsets.bottom)
        return@setOnApplyWindowInsetsListener WindowInsetsCompat.CONSUMED
    }
}