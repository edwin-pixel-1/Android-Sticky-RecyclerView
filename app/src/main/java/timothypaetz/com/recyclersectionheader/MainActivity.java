package timothypaetz.com.recyclersectionheader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));

        final List<Person> people = getPeople();

        PersonAdapter adapter = new PersonAdapter(getLayoutInflater(),
                people,
                R.layout.recycler_row);

        RecyclerSectionItemDecoration sectionItemDecoration =
                new RecyclerSectionItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_section_header_height),
                        true,
                        adapter);
        recyclerView.addItemDecoration(sectionItemDecoration);

        recyclerView.setAdapter(adapter);
    }

    private List<Person> getPeople() {
        PersonRepo personRepo = new PersonRepo();
        List<Person> people = personRepo.getPeople();
        Collections.sort(people);
        return people;
    }

    /*private RecyclerSectionItemDecoration.SectionCallback getSectionCallback(final List<Person> people) {
        return new RecyclerSectionItemDecoration.SectionCallback() {
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
        };
    }*/
}
