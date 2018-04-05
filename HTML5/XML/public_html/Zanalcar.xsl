<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Zanalcar.xsl
    Created on : 25 de marzo de 2018, 17:53
    Author     : Los Prieto
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/zanalcar">
        <html>
            <head>
                <title>Zanalcar.xsl</title>
            </head>
            <body>
                <h1>ZANALCAR</h1>
                <div style="display:flex; flex-direction:row; justify-content: space-around">
                    <div style="display:flex; flex-direction:column; background:purple; justify-content: space-around ">
                        <div style="border:5px solid black">
                            <h2>VEHICULOS A MOTOR</h2>
                            <div style="border:5px solid black">
                                <h3>COCHES</h3>
                                <table border="1" style="background:dodgerblue">
                                    <tr>
                                        <td>
                                            MARCA 
                                        </td>
                                        <td>
                                            COLOR 
                                        </td>
                                        <td>
                                            MATRICULA
                                        </td>
                                        <td>
                                            KM
                                        </td>
                                        <td>
                                            PRECIO DE COMPRA
                                        </td>
                                        <td>
                                            PRECIO DE VENTA
                                        </td>
                                    </tr>
                                    <xsl:for-each select="vehiculos/coche">
                                        <tr>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="marca"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="color"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="matricula"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="km"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="preciocompra"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="precioventa"/>
                                                </h2>
                                            </td>
                                        </tr>
                                    </xsl:for-each>
                                </table>
                            </div>  
                            <div style="border:5px solid black">
                                <h3>MOTOS</h3>
                                <table border="1" style="background:dodgerblue">
                                    <tr>
                                        <td>
                                            MARCA 
                                        </td>
                                        <td>
                                            COLOR 
                                        </td>
                                        <td>
                                            MATRICULA
                                        </td>
                                        <td>
                                            KM
                                        </td>
                                        <td>
                                            PRECIO DE COMPRA
                                        </td>
                                        <td>
                                            PRECIO DE VENTA
                                        </td>
                                    </tr>
                                    <xsl:for-each select="vehiculos/moto">
                                        <tr>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="marca"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="color"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="matricula"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="km"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="preciocompra"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="precioventa"/>
                                                </h2>
                                            </td>
                                        </tr>
                                    </xsl:for-each>
                                </table>
                            </div>
                            <div style="border:5px solid black">
                                <h3>QUAD</h3>
                                <table border="1" style="background:dodgerblue">
                                    <tr>
                                        <td>
                                            MARCA 
                                        </td>
                                        <td>
                                            COLOR 
                                        </td>
                                        <td>
                                            MATRICULA
                                        </td>
                                        <td>
                                            KM
                                        </td>
                                        <td>
                                            PRECIO DE COMPRA
                                        </td>
                                        <td>
                                            PRECIO DE VENTA
                                        </td>
                                    </tr>
                                    <xsl:for-each select="vehiculos/quad">
                                        <tr>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="marca"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="color"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="matricula"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="km"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="preciocompra"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="precioventa"/>
                                                </h2>
                                            </td>
                                        </tr>
                                    </xsl:for-each>
                                </table> 
                            </div>
                            <div style="border:5px solid black">
                                <h2>BICI</h2>
                                <table border="1" style="background:dodgerblue">
                                    <tr>
                                        <td>
                                            MARCA 
                                        </td>
                                        <td>
                                            COLOR 
                                        </td>
                                        <td>
                                            TAMAO DE RUEDA
                                        </td>
                                        <td>
                                            NUMERO DE MARCHAS
                                        </td>
                                        <td>
                                            TIPO DE CAMBIO
                                        </td>
                                        <td>
                                            PRECIO DE COMPRA
                                        </td>
                                        <td>
                                            PRECIO DE VENTA
                                        </td>
                                    </tr>
                                    <xsl:for-each select="vehiculos/bici">
                                        <tr>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="marca"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="color"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="tamañoderueda"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="numdemarchas"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="tipodecambio"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="preciocompra"/>
                                                </h2>
                                            </td>
                                            <td>
                                                <h2>
                                                    <xsl:value-of select="precioventa"/>
                                                </h2>
                                            </td>
                                        </tr>
                                    </xsl:for-each>
                                </table>
                            </div>
                        </div>          
                    </div>   
                </div>  
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
