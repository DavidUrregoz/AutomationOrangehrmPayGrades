Feature: Como Empleado admistrativo
necesito actualizar la información de pagos de los empleados
con el fin mantener al día las nominas de la empresa en la base de datos.

  Scenario: Modificación de grado de pago

    Given el empleado administrativo se encuentra logueado en la web de OrangeHRM y en la seccion de Job/Pay Grades.

    When el empleado administrativo modifique los grados de pago ya establecidos.

    Then el sistema debe guardar exitosamente los cambios anteriormente realizados.