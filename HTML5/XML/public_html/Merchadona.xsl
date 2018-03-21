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
            <body>
                <h1>MERCHADONA</h1>
                <table border="1">
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
                <table border="1">
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
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
