package southeast.edu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SensorReadingAdapter extends RecyclerView.Adapter<SensorReadingHolder>{
    private final List<SensorReading> sensorReadings;
    private Context context;
    private int itemResources;

    public SensorReadingAdapter(Context context, int itemResources, List<SensorReading> sensorReadings) {
        this.sensorReadings = sensorReadings;
        this.context = context;
        this.itemResources = itemResources;
    }

    @Override
    public SensorReadingHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(this.itemResources, parent,false);
        return new SensorReadingHolder (this.context, view);
    }

    @Override
    public void onBindViewHolder (SensorReadingHolder holder, int position){
        SensorReading sensorReading = this.sensorReadings.get(position);
        holder.bindSensorReading(sensorReading);
    }

    @Override
    public int getItemCount(){
        return this.sensorReadings.size();
    }
}
