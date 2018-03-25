<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Merchadona.xsl
    Created on : 21 de marzo de 2018, 11:08
    Author     : daw
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/merchadona">
        <html>
            <head>
                <title>Merchadona.xsl</title>
            </head>
            <body style="background:green">
                <h1>MERCHADONA</h1>
                <div style="display:flex; flex-direction:row; justify-content: space-around">
                <div style="display:flex; flex-direction:column; background:purple; justify-content: space-around ">
                    <h2>EMPLEADOS</h2>
                    <table border="1" style="background:dodgerblue">
                        <tr>
                            <td>
                                CAJEROS 
                            </td>
                            <td>
                                ID 
                            </td>
                            <td>
                                PRECIO TOTAL
                            </td>
                        </tr>
                        <xsl:for-each select="empleados/cajero">
                            <tr>
                                <td>
                                    <h2>
                                        <xsl:value-of select="nombre"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="id"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="preciototal"/>
                                    </h2>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>
                    <table border="4" style="background:orange;">
                        <tr>
                            <td>
                                REPONEDORES
                            </td>
                            <td>
                                ID 
                            </td>
                            <td>
                                Nº PRODUCTOS REPUESTOS
                            </td>
                        </tr>
                        <xsl:for-each select="empleados/reponedor">
                            <tr>
                                <td>
                                    <h2>
                                        <xsl:value-of select="nombre"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="id"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="numproductosrepuestos"/>
                                    </h2>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </div>      
                <div style="display:flex; flex-direction:column; background:purple; justify-content: space-around">
                    <h2>PRODUCTOS</h2>
                    <table border="1" style="background:dodgerblue">
                        <tr>
                            <td>
                                PRECIO BASE 
                            </td>
                            <td>
                                CANTIDAD 
                            </td>
                            <td>
                                NOMBRE
                            </td>
                        </tr>
                        <xsl:for-each select="productos/producto">
                            <tr>
                                <td>
                                    <h2>
                                        <xsl:value-of select="preciobase"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="cantidad"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="nombre"/>
                                    </h2>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>
                    <table border="1" style="background:orange">
                        <tr>
                            <td>
                                PRECIO BASE 
                            </td>
                            <td>
                                CANTIDAD 
                            </td>
                            <td>
                                NOMBRE
                            </td>
                            <td>
                                PRECIO CADUCADO
                            </td>
                            <td>
                                FECHA DE REPOSICIÓN
                            </td>
                        </tr>
                        <xsl:for-each select="productos/perecedero">
                            <tr>
                                <td>
                                    <h2>
                                        <xsl:value-of select="preciobase"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="cantidad"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="nombre"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="preciocaducado"/>
                                    </h2>
                                </td>
                                <td>
                                    <h2>
                                        <xsl:value-of select="fechareposicion"/>
                                    </h2>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </div> 
            </div>                        
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
