package com.ford.app.util;

public interface LogConstants {
	
	/* RestUserRegister class */
	
	String VALIDAR_USUARIO_MSJ = 
			"\n ======================================= \n"
			+ "*** VALIDANDO EXISTENCIA DE USUARIO *** \n "
			+ "========================================";
	
	String VALIDAR_CORREO_MSJ =  
			"\n "
			+ "================================================ \n"
			+ "*** VALIDANDO EXISTENCIA DE MAIL EN REGISTRO *** \n "
			+ "================================================";
	
	String VALIDAR_CONTRASENA_MSJ =  
			"\n "
			+ "====================================================== \n"
			+ "*** VALIDANDO EXISTENCIA DE CONTRASENA EN REGISTRO *** \n "
			+ "======================================================";
	
	String MAIL_EXISTENTE = "Mail existente::: ";

	String CONTRASENA_EXISTENTE = "Contraseña existente::: ";
	
	String USUARIO_EXISTENTE_TBL_REGISTRO = "\n USUARIO EXISTENTE DE LA TABLA: - user_register_fd - \n :::Favor de verificar:::";
	
	String USUARIO_INEXISTENTE =  
			"\n "
			+ "======================================== \n"
			+ "::: Usuario inexistente ::: \n "
			+ "::: continua con proceso de registro ::: \n "
			+ "======================================== \n "
			+ "RECIBIENDO DATOS DEL FORMULARIO HTML \n ";
	
	String NAME = "NAME::: ";
	String LAST_NAME = "LAST NAME::: ";
	String MAIL = "MAIL::: ";
	String PASSWORD = "PASSWORD::: ";
	String DATE = "DATE::: ";
	String LOCATION = "LOCATION::: ";
	String ACTIVE_ACCOUNT = "ACTIVE ACCOUNT::: ";
	String ADMIN = "ADMIN::: ";
	String USER = "USER::: ";
	
	String REGISTRO_TABLA_USER_REGISTER =  
			"\n "
			+ "======================================== \n"
			+ "*** REALIZANDO REGISTRO EN LA TABLA: *** \n "
			+ "     *** - user_register_fd - *** \n "
			+ "========================================";
	
	/* RestUserLogin */
	
	String VALIDAR_USUARIO_CONTRASENA = 
			"\n ===================================== \n"
			+ "*** VALIDANDO USUARIO Y CONTRASENA *** \n "
			+ "======================================";
	
	String EXTRAYENDO_INFO_TABLA_REGISTER = 
			"\n ===================================== \n"
			+ "*** EXTRAYENDO INFO DE LA TABLA: *** \n "
			+ "    *** - user_register_fd - *** \n "
			+ "======================================";
	
	String VALIDO = "VALIDO?::: ";
	
	String GUARDANDO_TABLA_USER_LOG =  
			"\n "
			+ "================================================ \n"
			+ "GUARDANDO LOG DE USUARIO EN TABLA: user_log_fd \n "
			+ "================================================";
	
	/* RestValidateMail */
	
	String VALIDAR_USUARIO_NUEVA_CONTRASENA = 
			"\n "
			+ "============================================================ \n"
			+ "*** VALIDANDO EXISTENCIA DE USUARIO PARA NUEVA CONTRASENA*** \n "
			+ "============================================================";
	
	/* RestSendMail */
	
	String RENOVAR_CONTRASENA = 
			"\n "
			+ "==================================== \n"
			+ "*** INICIANDO REGISTRO DE CODIGO *** \n "
			+ "*** PARA RENOVAR CONTRASENA *** \n "
			+ "====================================";
	
	String VALIDANDO_CORREO = "VALIDANDO EXISTENCIA DE CORREO: ";
	
	String CORREO_ENCONTRADO = "CORREO ENCONTRADO";
	
	String REGISTRO_TABLA_USER_CODE =  
			"\n "
			+ "======================================== \n"
			+ "*** REALIZANDO REGISTRO EN LA TABLA: *** \n "
			+ "       *** - user_code_fd - *** \n "
			+ "========================================";
	
	String ENVIANDO_CORREO_A = "ENVIANDO CORREO A: ";
	
	String CORREO_INEXISTENTE = "CORREO INEXISTENTE";
	
	/* RestUserCodeVerify */
	
	String VALIDANDO_CODIGO = "VALIDANDO CODIGO: ";
	
	String ACTUALIZANDO_CODIGO = "ACTUALIZANDO CODIGO: ";
	
	String SEPARATOR = " : ";
	
	/* RestUserUpdatePassword */
	
	String ACTUALIZANDO_CONTRASENA = "ACTUALIZANDO CONTRASENA: ";
	
	String DEL_CORREO = "DEL CORREO: ";
	
	/* RestInfoCar */
	
	String CREANDO_NUEVO_AUTO =  
			"\n "
			+ "========================================== \n"
			+ "*** INSERTANDO NUEVO AUTO EN LA TABLA: *** \n "
			+ "          *** - car_info_fd - *** \n "
			+ "==========================================";
	
	String NOMBRE_AUTO = "NOMBRE: ";
	String MODELO = "MODELO: ";
	String TIPO_DE_AUTO = "TIPO DE AUTO: ";
	String ANO = "ANO: ";
	String MOTOR = "MOTOR: ";
	String TRANSMICION = "TRANSMICION: ";
	String CILINDROS = "CILINDROS: ";
	String ESTILO = "ESTILO: ";
	String COMBUSTIBLE_EFICIENCIA = "COMBUSTIBLE EFICIENCIA: ";
	String SERIE = "SERIE: ";
	String TOP_SPEED = "TOP SPEED: ";
	String ACELERACION = "ACELERACION: ";
	String FRENOS = "FRENOS: ";
	String PORCENTAJE_COMBUSTIBLE = "PORCENTAJE COMBUSTIBLE: ";
	String TUNE = "TUNE: ";
	String MAS_INFO = "MAS INFO: ";
	String PRECIO = "PRECIO: ";
	
	/* RestUserAccount */
	
	String SEARCHING_USER_ACCOUNT =  
			"\n "
			+ "======================================== \n"
			+ "*** REALIZANDO BUSQUEDA EN LA TABLA: *** \n "
			+ "***       - user_account_fd -        *** \n "
			+ "========================================";
	
	String ID_USER = "ID USER: ";
	
	/* Update User */
	
	String REALIZANDO_ACTUALIZACION_DE_USUARIO = 
			"\n "
			+ "=========================================== \n"
			+ "*** REALIZANDO ACTUALIZACION DE USUARIO: *** \n "
			+ "		*** - user_register_fd - *** \n "
			+ "===========================================";
	
	String INSERTANDO_FECHA_DE_ACTUALIZACION_DE_USUARIO =  
			"\n "
			+ "======================================== \n"
			+ "*** INSERTANDO FECHA EN LA TABLA: *** \n "
			+ "***        - user_log_fd -        *** \n "
			+ "========================================";
	
	String BUSCANDO_ULTIMO_INGRESO_DE_USUARIO =  
			"\n "
			+ "============================================ \n"
			+ "*** BUSCANDO ULTIMO INGRESO EN LA TABLA: *** \n "
			+ "***        - user_log_fd -        *** \n "
			+ "============================================";
	
	/* Save New User Account */
	
	String GUARDANDO_NUEVA_CUENTA_USUARIO =  
			"\n "
					+ "=================================================== \n"
					+ "*** REALIZANDO CUENTADE USUSARIO EN LA TABLA: *** \n "
					+ "***        - user_account_fd -        *** \n "
					+ "===================================================";
	
	String USUARIO_CUENTA = "USER ID ACCOUNT: ";

}
