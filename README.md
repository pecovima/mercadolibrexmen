# mercadolibre

1. Ejecutar el comando "mvn package" 
2. En la carpeta target ejecutar el comando "java -jar mercadolibre-1.0.0.jar" (para iniciar la aplicación localmente)
3. Probar la aplicación con soapui, postman o curl local en
4. http://localhost:8080/v1/mutant
5. request validar mutante
{
	"dna":["ATGCGA","CAGTGC", "TTACGT","AGAAGG", "CCCTTA","TCACTG"]
}
6. consultar dna(GET)
7.  http://localhost:8080/v1/stats
8.  Para probar remotamente en google cloud, soapui ,postman o curl
9.  Registar: (POST)
10. https://mercado-libre-2021.oa.r.appspot.com/v1/mutant
11.  {
	"dna":["ATGCGA","CAGTGC", "TTACGT","AGAAGG", "CCCTTA","TCACTG"]
	}
11.  Consultar:(GET)
12.   https://mercado-libre-2021.oa.r.appspot.com/v1/stats

13. Para verificar la cobertura de codigo y pruebas unitarias \target\coverage-reports\index.html, aparece el reporte con jacoco
14. Documentacion de Swagger en la siguiente ruta
		##Local
		http://localhost:8080/swagger-ui.html#/
		
		##REMOTO
		https://mercado-libre-2021.oa.r.appspot.com/swagger-ui.html#/