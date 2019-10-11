package com.verifone.training

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_menu_item.view.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MenuItemFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MenuItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuItemFragment : Fragment() {
    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            menuItem = it.getParcelable<MenuItem>(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu_item, container, false)
        view.title.text = menuItem?.title
        view.description.text = menuItem?.description
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuItemFragment.
         */
        fun newInstance(menuItem : MenuItem) =
            MenuItemFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, menuItem)
                }
            }
    }
}
