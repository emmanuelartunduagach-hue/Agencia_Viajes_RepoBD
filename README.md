# README   
#   
# Sistema de Gestión Turística - Tatacoa Verde  
##  Descripción  
Este proyecto implementa una base de datos para la gestión de tours turísticos en el desierto de la Tatacoa.  
El sistema permite administrar usuarios, guías, tours, disponibilidad, reservas y reseñas, integrando un flujo de pago externo mediante WhatsApp.  
  
## Funcionalidades  
* Gestión de usuarios (superadmin, admin, guía)  
* Administración de tours y categorías  
* Asignación de guías a tours  
* Manejo de disponibilidad (fechas y cupos)  
* Sistema de reservas  
* Opciones de acomodación (pareja / múltiple)  
* Auditoría de cambios (historial)  
* Sistema de reseñas  
* Integración con WhatsApp  
  
## Base de Datos  
Nombre:  
gestion_turistica  
  
##  Instalación  
1. Abrir MySQL Workbench  
2. Ejecutar el archivo:  
```
schema.sql

```
  
## Estructura  
```
proyecto_tatacoa/
│
├── database/
│   └── schema.sql
│
├── README.md

```
  
## Uso en Backend  
Para levantar la base de datos:  
```
mysql -u root -p < schema.sql

```
  
## Nota  
Los pagos se gestionan mediante WhatsApp, pero el sistema incluye una tabla pago para futuras implementaciones.  
##   
##  Autor  
Proyecto académico - Tatacoa Verde  
