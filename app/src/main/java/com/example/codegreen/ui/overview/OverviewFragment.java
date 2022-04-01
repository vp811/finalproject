package com.example.codegreen.ui.overview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.codegreen.CO2DataObject;
import com.example.codegreen.MainActivity;
import com.example.codegreen.R;
import com.example.codegreen.databinding.FragmentHomeBinding;
import com.example.codegreen.databinding.FragmentOverviewBinding;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class OverviewFragment extends Fragment {

    private OverviewViewModel overviewViewModel;
    private FragmentOverviewBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        overviewViewModel =
                new ViewModelProvider(this).get(OverviewViewModel.class);

        binding = FragmentOverviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonOverviewUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_overview_to_navigation_userprofile);
            }
        });

        binding.buttonOverviewSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_navigation_overview_to_navigation_settings);
            }
        });

        View roots = inflater.inflate(R.layout.fragment_overview, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        CO2DataObject co2 = mainActivity.getUser().getUserCO2Data();
        double foodCo2 = co2.getFood();
        double transportCo2 = co2.getTransport();
        double clothingCo2 = co2.getClothing();
        double otherCo2 = co2.getOther();
        double totalCo2 = foodCo2 + transportCo2 + clothingCo2 + otherCo2;
        if (totalCo2 == 0) {
            totalCo2 = 1;
        }
        binding.tvFood.setText(String.format("%.1f", foodCo2 * 100 / totalCo2));
        binding.tvTransport.setText(String.format("%.1f", transportCo2 * 100 / totalCo2));
        binding.tvClothing.setText(String.format("%.1f", clothingCo2 * 100 / totalCo2));
        binding.tvOthers.setText(String.format("%.1f", otherCo2 * 100 / totalCo2));

        binding.textViewFood.setText("Food (" + foodCo2  + " KG)");
        binding.textViewTransport.setText("Transport (" + transportCo2  + " KG)");
        binding.textViewClothing.setText("Clothing (" + clothingCo2  + " KG)");
        binding.textViewOther.setText("Other (" + otherCo2  + " KG)");

        // Set the data and color to the pie chart
        binding.piechart.addPieSlice(
                new PieModel(
                        "Food (" + foodCo2  + " KG)",
                        Math.round(foodCo2 * 100 / totalCo2),
                        Color.parseColor("#FFA726")));
        binding.piechart.addPieSlice(
                new PieModel(
                        "Transport (" + transportCo2  + " KG)",
                        Math.round(transportCo2 * 100 / totalCo2),
                        Color.parseColor("#66BB6A")));
        binding.piechart.addPieSlice(
                new PieModel(
                        "Other (" + otherCo2  + " KG)",
                        Math.round(otherCo2 * 100 / totalCo2),
                        Color.parseColor("#29B6F6")));
        binding.piechart.addPieSlice(
                new PieModel(
                        "Clothing (" + clothingCo2  + " KG)",
                        Math.round(clothingCo2 * 100 / totalCo2),
                        Color.parseColor("#EF5350")));

        // To animate the pie chart
        binding.piechart.startAnimation();


        return root;
    }
}