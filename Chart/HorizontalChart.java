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
    <com.github.mikephil.charting.charts.HorizontalBarChart
        android:id="@+id/horizontalChart"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
		
// example
	// Encontre o BarChart no layout
	HorizontalBarChart horizontalBarChart = findViewById(R.id.horizontalChart);

	// Criar dados de exemplo
	List<BarEntry> entries = new ArrayList<>();
	for(int i = 1; i < 30; i++) {
		entries.add(new BarEntry(i, (float) (Math.random() * 100)));
	}

	// Configurar conjunto de dados e estilo
	BarDataSet dataSet = new BarDataSet(entries, "vazão");
	dataSet.setColor(Color.GREEN);
	dataSet.setValueTextColor(Color.BLACK);

	// Configurar o conjunto de dados no gráfico
	BarData barData = new BarData(dataSet);
	horizontalBarChart.setData(barData);

	// configuration chart
	horizontalBarChart.animateY(3000);
	horizontalBarChart.getDescription().setEnabled(false);

	// Configurar eixos
	YAxis yAxis = horizontalBarChart.getAxisLeft();
	yAxis.setDrawLabels(false); // Ocultar rótulos do eixo Y
	YAxis yAxisRight = horizontalBarChart.getAxisRight();
	yAxisRight.setEnabled(false); // Desabilitar o eixo direito (opcional)

	XAxis xAxis = horizontalBarChart.getXAxis();
	xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

	// Configurar legenda
	Legend legend = horizontalBarChart.getLegend();
	legend.setTextColor(Color.BLACK);

	// Atualizar o gráfico
	horizontalBarChart.invalidate();

