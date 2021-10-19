package com.funcrib.wilsonteamapt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.funcrib.wilsonteamapt.R
import com.funcrib.wilsonteamapt.data.RvCard
import com.funcrib.wilsonteamapt.databinding.FragmentHomeBinding
import com.funcrib.wilsonteamapt.util.DummyData
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var rvAdapter: CardAdapter

    private var totalAmount = 850
    private var currentAmount = 150
    private var progress = totalAmount / 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            /*Initialize Views*/
            recyclerView = cardRv

            recyclerView.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                rvAdapter = CardAdapter()
                adapter = rvAdapter
                rvAdapter.submitList(list)
            }

            val formattedNumber = java.text.NumberFormat.getIntegerInstance().format(totalAmount)
            currentAccountBalanceTv.text = getString(R.string.total_amount_tv, formattedNumber)
            accountTopUpTv.text = getString(R.string.current_amount_tv, currentAmount.toString())

            circularProgressIndicator.setProgress(progress, true)


            addItemImageView.setOnClickListener {
                if (totalAmount <= 10000) {
                    val newCurrentAmount = (300..1000).random()
                    currentAmount = newCurrentAmount
                    totalAmount += newCurrentAmount

                    progress = totalAmount / 100

                    updateViews()
                    insertItem(newCurrentAmount.toString())

                } else {

                    val dialog = BottomSheetDialog(requireContext(),
                        R.style.BottomSheetDialogStyle)

                    val bottomSheetView: View = layoutInflater.inflate(
                        R.layout.fragment_item_list_dialog_list_dialog,
                        dialog.findViewById<ConstraintLayout>(R.id.bottom_sheet)
                    )

                    bottomSheetView.findViewById<Button>(R.id.alrighty_button).setOnClickListener {
                        dialog.dismiss()
                    }

                    dialog.setContentView(bottomSheetView)
                    dialog.show()
                }
            }
        }

    }

    /*Update views*/
    private fun updateViews() {
        binding.apply {
            val formattedNumber = java.text.NumberFormat.getIntegerInstance().format(totalAmount)
            currentAccountBalanceTv.text = getString(R.string.total_amount_tv, formattedNumber)
            accountTopUpTv.text = getString(R.string.current_amount_tv, currentAmount.toString())

            circularProgressIndicator.setProgress(progress, true)
        }
    }

    /*Insert New Item to start of recycler view*/
    private fun insertItem(item: String) {
        val randomColor = DummyData.colors.random()

        val newItem = RvCard(
            DummyData.imageList.random(),
            DummyData.parentList.random(),
            DummyData.useCase.random(),
            item,
            randomColor.colorOne,
            randomColor.colorTwo
        )
        list.add(0, newItem)
        rvAdapter.submitList(list)
        rvAdapter.notifyItemInserted(0)
        recyclerView.scrollToPosition(0)
    }

    /*Init list*/
    private val randomColor = DummyData.colors.random()
    private val list: MutableList<RvCard> = mutableListOf(
        RvCard(
            DummyData.imageList.random(),
            DummyData.parentList.random(),
            DummyData.useCase.random(),
            "150",
            randomColor.colorOne,
            randomColor.colorTwo
        ),
        RvCard(
            DummyData.imageList.random(),
            DummyData.parentList.random(),
            DummyData.useCase.random(),
            "350",
            DummyData.colors.random().colorOne,
            DummyData.colors.random().colorTwo
        ),
        RvCard(
            DummyData.imageList.random(),
            DummyData.parentList.random(),
            DummyData.useCase.random(),
            "300",
            DummyData.colors.random().colorOne,
            DummyData.colors.random().colorTwo
        )
    )
}