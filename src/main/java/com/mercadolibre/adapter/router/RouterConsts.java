package com.mercadolibre.adapter.router;

public class RouterConsts {

    private RouterConsts(){}
    /**
     * componentes
     */
    public static final String COMPONENT_SCAN = "com.mercadolibre";

    /**
     * Documentacion swagger
     */
    public static final String SWAGGER_TITTLE = "Servicio Xmen Mutantes";
    public static final String SWAGGER_DESCRIPTION = "Servicio-Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar\n" +
            "contra los X-Men";
    public static final String SWAGGER_VERSION = "1.0.0";

    /**
     * Controller config
     */
    public static final String API = "Xmen Mutantes";
    public static final String CROSS_ORIGIN = "*";
    public static final String CONTROLLER_PATH = "/v1";
    public static final String MAPPING_STATUS = "/";
    public static final String MAPPING_POST_MUTANT = "/mutant";
        public static final String MAPPING_GET_MUTANT= "/stats";

    /**
     * mensajes
     */
    public static final String MESSAGE_STATUS= "<h1>Xmen Mutantes Service </h1> <h4><b style='color:green'> Online <b></h4><h5 style = 'color:black'> %s </h5>";

    /**
     * operaciones o metodos
     */
    public static final String API_OPERATION_MUTANT = "Post Mutante";
    public static final String API_OPERATION_MUTANT_GET = "Get Mutante";


    /**
     * descripcion de las operaciones o metodos
     */
    public static final String NOTE_API_OPERATION_POST_MUTANT = "Servicio que permite saber si un humano es mutante, si es mutante guarda la informacion de ADN";
    public static final String NOTE_API_OPERATION_GET_MUTANT= "Servicio que obtiene los mutantes registrados en base de datos H2";


    /**
     * mensajes de respuesta de acuerdo al codigo http
     */
    public static final String API_RESPONSE_COD_200 = "Proceso exitoso";
    public static final String API_RESPONSE_COD_400 = "Falta algún parámetro en la cabecera";
    public static final String API_RESPONSE_COD_404 = "No se puede determinar la posición o el mensaje.";
    public static final String API_RESPONSE_COD_422 = "Error funcional en la aplicación";
    public static final String API_RESPONSE_COD_500 = "Error desconocido";

    /**
     * swagger param
     */
    public static final String API_PARAM_REQUEST_MS = "Body de la petición mapeado a un objeto MutantDTO.";

}
