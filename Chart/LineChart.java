// build.android (:app)
implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'

// settings.gradle
dependencyResolutionManagement {
    ...
    repositories {
		...
        maven { url 'https://jitpack.io' }
    }
}

// xml
    <com.github.mikephil.charting.charts.LineChart
        android:id="@+id/lineChart"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
		
// example
	// Encontre o BarChart no layout
	LineChart lineChart = findViewById(R.id.lineChart);

	// Criar dados de exemplo
	List<Entry> entries1 = new ArrayList<>();
	List<Entry> entries2 = new ArrayList<>();
	entries1.add(new Entry(1, 10));
	entries1.add(new Entry(2, 20));
	entries1.add(new Entry(3, 15));
	entries1.add(new Entry(4, 25));
	entries1.add(new Entry(5, 18));

	entries2.add(new Entry(1, 18));
	entries2.add(new Entry(2, 25));
	entries2.add(new Entry(3, 15));
	entries2.add(new Entry(4, 20));
	entries2.add(new Entry(5, 10));

	// Criar conjunto de dados com as entradas
	LineDataSet dataSet1, dataSet2;
	dataSet1 = new LineDataSet(entries1, "Temperatura");
	dataSet2 = new LineDataSet(entries2, "Umidade");

	// Personalizar as cores
	dataSet1.setColors(Color.BLUE);
	dataSet2.setColors(Color.GREEN);

	// Configurar o conjunto de dados no gráfico
	LineData lineData = new LineData(dataSet1, dataSet2);
	lineChart.setData(lineData);

	// configuration chart
	lineChart.animateY(3000);
	lineChart.getDescription().setEnabled(false);

	// Configurar eixos
	XAxis xAxis = lineChart.getXAxis();
	xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

	YAxis yAxisLeft = lineChart.getAxisLeft();
	YAxis yAxisRight = lineChart.getAxisRight();
	yAxisRight.setEnabled(false); // Desabilitar o eixo direito (opcional)

	// Configurar legenda
	Legend legend = lineChart.getLegend();
	legend.setTextColor(Color.BLACK);

	// Atualizar o gráfico
	lineChart.invalidate();

