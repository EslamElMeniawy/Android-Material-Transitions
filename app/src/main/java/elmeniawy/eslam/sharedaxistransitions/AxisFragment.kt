package elmeniawy.eslam.sharedaxistransitions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elmeniawy.eslam.sharedaxistransitions.databinding.FragmentAxisBinding

class AxisFragment : Fragment() {
    private var _binding: FragmentAxisBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.
        _binding = FragmentAxisBinding.inflate(inflater, container, false)
        return _binding?.root
    }
}