var app = angular.module('idxApp', ['ui.bootstrap']);
 
var url = window.location.origin;
var valor = "";
var fecha = "";

app.controller('resultadoController', function ($scope, $http) {
	
	$scope.scotches = []; 
	$http.get(url + '/consumoInfoCompleta')
	.success(function (data) {
	  $scope.scotches=data;
	}).error(function (data, status, headers, config) {
 		console.log(data);
        $scope.loading = false;
	});
});

app.controller('valorController', function ($scope, $http) {
	
	valor = window.location.pathname;
	var valores = valor.split("/");
	console.log(valores[2]);
	valor = valores[2];
	console.log(valor);
	var pasa = false;
	$scope.valores = []; 
	$http.post(url + '/consumoSoloValor', {
		"valor" : valor
	}).success(function (data, status, headers, config) {
		if(data != null){
			$scope.valores=data;
		}
	}).error(function (data, status, headers, config) {
		console.log('Error en el consumo del servicio rest');
	});
});

app.controller('valorFechaController', function ($scope, $http) {
	
	valor = window.location.pathname;
	var valores = valor.split("/");
	valor = valores[2];
	fecha = valores[3];
	console.log(valor);
	console.log(fecha);
	var pasa = false;
	$scope.valorFecha = []; 
	$http.post(url + '/consumoPorValorFecha', {
		"valor" : valor,
		"fecha": fecha 
	}).success(function (data, status, headers, config) {
		if(data != null){
			$scope.valorFecha=data;
		}
	}).error(function (data, status, headers, config) {
		console.log('Error en el consumo del servicio rest');
	});
});

app.controller('valoresController', ['$scope', '$http', '$window', function($scope, $http, $window){
    
    $scope.cargarPorValor = function(){
    	valor = document.getElementById("valor");
    	console.log(valor.value);
    	var pasa = false;
    	$scope.valores = []; 
    	if(valor.value != "" && valor.value != null){
    		pasa = true;
    	}else{
    		alert("Debe ingresar valor");
    	}
    	if(pasa){
    		abrirVentanaValor();
    	}
    };    
}]);

app.controller('valoresYFechaController', ['$scope', '$http', '$window', function($scope, $http, $window){
    
    $scope.cargarPorValorYFecha = function(){
    	valor = document.getElementById("valor");
    	fecha = document.getElementById("fecha");
    	console.log(valor.value);
    	var pasa = false;
    	$scope.valores = []; 
    	if(valor.value != "" && valor.value != null){
    		pasa = true;
    	}else{
    		alert("Debe ingresar valor");
    		pasa = false;
    	}
    	
    	if(fecha.value != "" && fecha.value != null){
    		pasa = true;
    	}else{
    		alert("Debe ingresar fecha");
    		pasa = false;
    	}
    	if(pasa){
    		var fechas = "20200301"
    		abrirVentanaValorFecha();
    	}
    };    
}]);

function abrirVentanaValor(){
	window.open("/resultadoValor/"+valor.value, "_self");
}

function abrirVentanaValorFecha(){
	window.open("/resultadoValorFecha/"+valor.value+"/"+fecha.value, "_self");
}