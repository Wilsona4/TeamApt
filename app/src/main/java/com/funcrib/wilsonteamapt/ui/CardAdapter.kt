package com.funcrib.wilsonteamapt.ui

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.funcrib.wilsonteamapt.R
import com.funcrib.wilsonteamapt.data.RvCard
import com.funcrib.wilsonteamapt.databinding.RvItemBinding

class CardAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<RvCard>() {

        override fun areItemsTheSame(
            oldItem: RvCard,
            newItem: RvCard,
        ): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(
            oldItem: RvCard,
            newItem: RvCard,
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<RvCard>) {
        differ.submitList(list)
    }

    class ViewHolder
    constructor(
        private val binding: RvItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RvCard) = with(binding) {


//            ObjectAnimator.ofFloat(itemView, "translationY", -100f, 0f).apply {
//                duration = 1000
//                interpolator = OvershootInterpolator()
//                start()
//            }

            ObjectAnimator.ofFloat(itemView, "rotationX", 180f, 360f).apply {
                duration = 500
                interpolator = AccelerateDecelerateInterpolator()
                start()
            }

//            val fadeAnimator = ObjectAnimator.ofFloat(itemView, "alpha", 1.0f, 0.0f)
//            fadeAnimator.apply {
//                duration = 1000
//                repeatCount = 1
//                repeatMode = ValueAnimator.REVERSE
//                start()
//            }


//            val animation = AnimationUtils.loadAnimation(this.cardView.context, R.anim.slide_in_up)
//            itemView.startAnimation(animation)

            binding.apply {
                rvItemParentNameTv.text = item.parent
                rvItemUsageTv.text = item.useCase
                rvItemAmountTv.text =
                    rvItemAmountTv.context.getString(R.string.current_amount_tv, item.Amount)

                circleImageView.setImageResource(item.image)

                cardView.setCardBackgroundColor(
                    ContextCompat.getColor(cardView.context, item.primaryColor)
                )
                rvItemAmountTv.setTextColor(ContextCompat.getColor(cardView.context,
                    item.SecondaryColor))
                circleImageView.circleBackgroundColor =
                    ContextCompat.getColor(cardView.context, item.SecondaryColor)
            }
        }
    }

}