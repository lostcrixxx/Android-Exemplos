implementation 'androidx.recyclerview:recyclerview:<versão>'

// item_list.xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="16dp">

    <!-- Defina a estrutura do item da lista aqui -->
    <TextView
        android:id="@+id/item_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

</LinearLayout>

// MeuAdapter
public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.ViewHolder> {

    private List<String> listaItens;

    public MeuAdapter(List<String> listaItens) {
        this.listaItens = listaItens;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = listaItens.get(position);
        holder.itemTextView.setText(item);
    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.item_text);
        }
    }
}


// activity_main.xml
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/recycler_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
	
// MainActivity
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MeuAdapter adapter;
    private List<String> listaItens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaItens = new ArrayList<>();
        // Preencha a lista de itens com os dados desejados

        adapter = new MeuAdapter(listaItens);
        recyclerView.setAdapter(adapter);
    }
}


