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
    <com.github.mikephil.charting.charts.BarChart
        android:id="@+id/barChart"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
		
// example
	// Encontre o BarChart no layout
	BarChart barChart = view.findViewById(R.id.barChart);

	// Criar dados de exemplo para o gráfico de barras
	List<BarEntry> entries = new ArrayList<>();
	entries.add(new BarEntry(1f, 2));
	entries.add(new BarEntry(2f, 4));
	entries.add(new BarEntry(3f, 1));
	entries.add(new BarEntry(4f, 7));
	entries.add(new BarEntry(5f, 3));

	// Criar conjunto de dados com as entradas
	BarDataSet dataSet = new BarDataSet(entries, "Bateria");

	// Personalizar as cores
	dataSet.setColors(Color.rgb(33, 150, 243)); // Cor azul

	// Criar os dados a serem exibidos no gráfico
	BarData barData = new BarData(dataSet);

	// Configurar o gráfico
	barChart.setData(barData);
	barChart.setDrawGridBackground(false);
	barChart.setDrawBorders(false);
	barChart.getDescription().setEnabled(false);

	// Configurar eixos
	XAxis xAxis = barChart.getXAxis();
	xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
	xAxis.setDrawGridLines(false);

	YAxis leftAxis = barChart.getAxisLeft();
	leftAxis.setDrawGridLines(false);

	YAxis rightAxis = barChart.getAxisRight();
	rightAxis.setEnabled(false);

	// Adicionar descrição ao gráfico
	Description description = new Description();
	description.setText("Exemplo de Gráfico de Barras");
	barChart.setDescription(description);

	// Atualizar o gráfico
	barChart.invalidate();

