/**
 * Dashboard Analytics
 */

'use strict';

(function () {
  const salesXExpensesEl = document.querySelector('#salesXExpenses'),
    salesXExpensesOptions = {
      series: [{
        name: 'Quantidade',
        data: [400, 200]
      }, {
        name: 'Preço',
        data: [2000, 3200]
      }],
      colors: [config.colors.primary, config.colors.success],
      chart: {
        type: 'bar',
        height: 200
      },
      plotOptions: {
        bar: {
          horizontal: true,
          dataLabels: {
            position: 'top',
          },
        }
      },
      dataLabels: {
        enabled: true,
        offsetX: -6,
        style: {
          fontSize: '12px',
          colors: ['#fff']
        }
      },
      stroke: {
        show: true,
        width: 1,
        colors: ['#fff']
      },
      tooltip: {
        shared: true,
        intersect: false
      },
      xaxis: {
        categories: ['Vendas', 'Despesas'],
      },
    };
  if (typeof salesXExpensesEl !== undefined && salesXExpensesEl !== null) {
    const salesXExpenses = new ApexCharts(salesXExpensesEl, salesXExpensesOptions);
    salesXExpenses.render();
  }

  const productsSoldEl = document.querySelector('#productsSold'),
    productsSoldOptions = {
      series: [10, 60, 30, 50, 70],
      labels: ['Abacate', 'Alface', 'Feijão', 'Manga', 'Repolho'],
      colors: ['#84d474', '#a1c7a3', '#a87c42', '#f0bf69', '#dfd8a2'],
      chart: {
        type: 'donut',
      }
    };
  if (typeof productsSoldEl !== undefined && productsSoldEl !== null) {
    const productsSold = new ApexCharts(productsSoldEl, productsSoldOptions);
    productsSold.render();
  }

  const expenseDetailsEl = document.querySelector('#expenseDetails'),
    expenseDetailsConfig = {
      series: [44, 55, 41, 17, 15],
      labels: ['Água', 'Energia', 'Ferramentas', 'Obras', 'Adubo'],
      colors: ['#84d474', '#a1c7a3', '#a87c42', '#f0bf69', '#dfd8a2'],
      chart: {
        type: 'donut',
      }
    };
  if (typeof expenseDetailsEl !== undefined && expenseDetailsEl !== null) {
    const expenseDetails = new ApexCharts(expenseDetailsEl, expenseDetailsConfig);
    expenseDetails.render();
  }

  const productsInStockEl = document.querySelector('#productsInStock'),
    productsInStockConfig = {
      series: [60, 40, 15, 20, 5],
      labels: ['Mandioca', 'Banana', 'Manga', 'Feijão', 'Alface'],
      colors: ['#84d474', '#a1c7a3', '#a87c42', '#f0bf69', '#dfd8a2'],
      chart: {
        type: 'donut',
      }
    };
  if (typeof productsInStockEl !== undefined && productsInStockEl !== null) {
    const productsInStock = new ApexCharts(productsInStockEl, productsInStockConfig);
    productsInStock.render();
  }

  const expenseSavingsEl = document.querySelector('#expenseSavings'),
    expenseSavingsConfig = {
      series: [{
        name: "Água",
        data: [500, 450]
      },
      {
        name: "Energia",
        data: [260, 255]
      },
      {
        name: 'Obras',
        data: [220, 400]
      }
      ],
      colors: ['#3c604a', '#84d474', '#a1c7a3'],
      chart: {
        height: 350,
        type: 'line',
        zoom: {
          enabled: false
        },
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: [5, 7, 5],
        curve: 'straight',
        dashArray: [0, 8, 5]
      },
      markers: {
        size: 0,
        hover: {
          sizeOffset: 6
        }
      },
      xaxis: {
        categories: ['Jun', 'Ago'],
      }
    };
  if (typeof expenseSavingsEl !== undefined && expenseSavingsEl !== null) {
    const expenseSavings = new ApexCharts(expenseSavingsEl, expenseSavingsConfig);
    expenseSavings.render();
  }

  const profitProductsEl = document.querySelector('#profitProducts'),
    profitProductsConfig = {
      series: [{
        name: "Alface",
        data: [200, 250]
      },
      {
        name: "Batata",
        data: [1200, 1300]
      },
      {
        name: 'Banana',
        data: [3000, 2500]
      }
      ],
      colors: ['#a87c42', '#f0bf69', '#dfd8a2'],
      chart: {
        height: 350,
        type: 'line',
        zoom: {
          enabled: false
        },
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: [5, 7, 5],
        curve: 'straight',
        dashArray: [0, 8, 5]
      },
      markers: {
        size: 0,
        hover: {
          sizeOffset: 6
        }
      },
      xaxis: {
        categories: ['Jun', 'Ago'],
      }
    };
  if (typeof profitProductsEl !== undefined && profitProductsEl !== null) {
    const profitProducts = new ApexCharts(profitProductsEl, profitProductsConfig);
    profitProducts.render();
  }
})();
