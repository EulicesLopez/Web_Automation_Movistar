Feature: Flujo Delivery Movistar
  _Feature para automatizar flujo de Delivery movistar

  @DeliveryMovistar
  Scenario Outline: Delivery Movistar
    Given Usuario se encuentra en el aplicativo Web Delivery
    When Completa datos de la direccion y da clic en el boton Consultar ubicacion "<caso_de_prueba>"
    And Completa datos de la direccion completa y da clic en el boton Confirmar ubicacion "<caso_de_prueba>"
    And Completa datos de entrega "<caso_de_prueba>"
    Then Usuario da clic en boton Confirmar delivery
    And Verifica el Servicio Delivery
    Examples:
      | caso_de_prueba |
      | 1              |


  @BandejaAudio
  Scenario: Bandeja de Audio
    Given Usuario se encuentra en el aplicativo Bandeja Audio
    When Click en Bandeja de Back Office
    And Ver detalle de la orden
    Then Realizar carga de audio
    And Verificar registro de carga de audio

