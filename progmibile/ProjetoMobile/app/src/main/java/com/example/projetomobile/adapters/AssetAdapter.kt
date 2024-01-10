package com.example.projetomobile.adapters

import com.example.projetomobile.preferences.PreferencesManager
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projetomobile.models.Asset
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData
import com.example.projetomobile.databinding.ItemAssetBinding
import com.example.projetomobile.databinding.ItemAssetExpandedBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.projetomobile.R

interface AssetClickListener {
    fun onAssetClicked(asset: Asset)
}

class AssetAdapter(
    private val layoutInflater: LayoutInflater,
    private val onAssetClicked: (Asset) -> Unit,
    private val preferencesManager: PreferencesManager,
    private val clickListener: AssetClickListener
) : RecyclerView.Adapter<AssetAdapter.AssetViewHolder>() {

    val assets = mutableListOf<Asset>()

    private var onItemClickListener: ((Asset) -> Unit)? = null

    fun setOnItemClickListener(listener: (Asset) -> Unit) {
        onItemClickListener = listener
    }

    fun updateData(newAssets: List<Asset>) {
        assets.clear()
        assets.addAll(newAssets)
        notifyItemRangeChanged(0, newAssets.size)
        Log.d("AssetAdapter", "Data updated. New size: ${assets.size}")
        Log.d("AssetAdapter", "Data updated. New assets: $newAssets")
    }

    fun updateSelectedAssets(selectedAssets: List<Asset>) {
        // Atualize a UI com base nos ativos selecionados
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        val binding = ItemAssetBinding.inflate(layoutInflater, parent, false)
        return AssetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        val asset = assets[position]
        holder.assetCheckbox.isChecked = asset.isSelected
        holder.bind(asset)
    }

    override fun getItemCount(): Int = assets.size

    inner class AssetViewHolder(private val binding: ItemAssetBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val assetCheckbox: CheckBox = binding.assetCheckbox

        private val assetSymbol = binding.AssetSymbol
        private val assetPrice = binding.AssetPrice
        private val assetChangePercent = binding.AssetChangePercent
        private val expandedCard: FrameLayout = binding.expandedCard
        private val ceoTextView: TextView
        private val sectorTextView: TextView
        private val descriptionTextView: TextView
        private val lineChart: LineChart
        private val expandedBinding: ItemAssetExpandedBinding = ItemAssetExpandedBinding.inflate(layoutInflater)

        init {
            setupOnClickListener()
            ceoTextView = expandedBinding.CEOTextView
            sectorTextView = expandedBinding.SectorTextView
            descriptionTextView = expandedBinding.DescriptionTextView
            lineChart = expandedBinding.lineChart
        }

        private fun setupOnClickListener() {
            itemView.setOnClickListener {
                val asset = assets[absoluteAdapterPosition]
                if (!asset.isExpanded) {
                    assetCheckbox.isChecked = !assetCheckbox.isChecked
                    asset.isSelected = assetCheckbox.isChecked
                    clickListener.onAssetClicked(asset)
                    toggleExpandedState(asset)
                    Log.d("AssetAdapter", "Asset Clicked: $asset")
                }
            }
        }

        fun bind(asset: Asset) {
            Log.d("AssetAdapter", "Binding Asset: $asset")
            // Adicione logs específicos para verificar os valores dos atributos
            Log.d("AssetAdapter", "Logo URL: ${asset.logoUrl}")
            Log.d("AssetAdapter", "Symbol: ${asset.symbol}")
            Log.d("AssetAdapter", "Current Price: ${asset.currentPrice}")
            Log.d("AssetAdapter", "Percent Change: ${asset.percentChange}")

            with(asset) {
                if (isExpanded) {
                    ceoTextView.text = "CEO: $ceo"
                    sectorTextView.text = "Sector: $sector"
                    descriptionTextView.text = "Description: $description"

                    if (expandedCard.childCount == 0) {
                        expandedCard.addView(expandedBinding.root)
                    }

                    val chartData = asset.chartData
                    if (chartData != null) {
                        val entries = chartData.entries.mapIndexed { index, value ->
                            Entry(index.toFloat(), value.toString().toFloatOrNull() ?: 0f)
                        }

                        val dataSet = LineDataSet(entries, "Chart Data")
                        val lineData = LineData(dataSet)

                        lineChart.data = lineData
                        lineChart.invalidate()
                    }
                } else {
                    expandedCard.removeAllViews()
                    // Código para exibir informações quando o cartão não está expandido
                    assetSymbol.text = "$symbol"
                    assetPrice.text = "$currentPrice"
                    val changePercentValue = percentChange
                    assetChangePercent.text = "$changePercentValue"
                    // Definindo a cor com base no valor do percentual de mudança
                    assetChangePercent.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            if (changePercentValue > 0) R.color.green else if (changePercentValue < 0) R.color.red else R.color.colorPrimary
                        )
                    )
                }
            }
            // Atualize o estado do CheckBox
            assetCheckbox.isChecked = asset.isSelected

            Log.d("AssetAdapter", "Binding Asset: $asset")

            Glide.with(itemView)
                .load(asset.logoUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.AssetLogo)
        }
    }

    fun toggleExpandedState(asset: Asset) {
        val position = assets.indexOf(asset)
        if (position != -1) {
            asset.isExpanded = !asset.isExpanded
            notifyItemChanged(position)
        }
    }
}