package timothypaetz.com.recyclersectionheader;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by paetztm on 2/6/2017.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements RecyclerSectionItemDecoration.SectionCallback{

    private final List<Person>   people;
    private final LayoutInflater layoutInflater;
    private final int            rowLayout;

    public PersonAdapter(LayoutInflater layoutInflater, List<Person> people, @LayoutRes int rowLayout) {
        this.people = people;
        this.layoutInflater = layoutInflater;
        this.rowLayout = rowLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(rowLayout,
                                        parent,
                                        false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = people.get(position);
        holder.fullName.setText(person.getFullName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    @Override
    public boolean isSection(int position) {
        boolean result = position == 0
                || !people.get(position)
                .getBirthdayDate().equals(people.get(position - 1)
                        .getBirthdayDate());
        return result;
    }

    @Override
    public CharSequence getSectionHeader(int position) {
        return people.get(position)
                .getBirthdayDate()
                + " - Header";
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fullName;

        public ViewHolder(View view) {
            super(view);
            fullName = (TextView) view.findViewById(R.id.full_name_tv);
        }
    }
}
