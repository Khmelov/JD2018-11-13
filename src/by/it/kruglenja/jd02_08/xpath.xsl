<?xml version= "1.0" encoding= "UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/spareparts/part">
        <table border="1">
            <tr>
                <td>Model</td>
                <td>Category</td>
                <td>Name</td>
                <td>Serial</td>
                <td>Weigth</td>
                <td>Size</td>
            </tr>
            <xsl:apply-templates/>
            <!--<tr>-->
                <!--<td>Address</td>-->
                <!--<td>Quanity</td>-->

            <!--</tr>-->
        </table>
    </xsl:template>

    <xsl:template match="/spareparts/part/descrition">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/spareparts/part/descrition/model">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/spareparts/part/descrition/category">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/spareparts/part/descrition/name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/spareparts/part/descrition/serial_number" xml:id="1">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/spareparts/part/descrition/weigth">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/spareparts/part/descrition/size">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <!--<xsl:template match="/spareparts/part/availableness/shops/adress">-->
        <!--<td>-->
            <!--<xsl:apply-templates/>-->
        <!--</td>-->
    <!--</xsl:template>-->

    <!--<xsl:template match="/spareparts/part/availableness/shops/quanity" >-->
        <!--<td>-->
            <!--<xsl:apply-templates/>-->
        <!--</td>-->
    <!--</xsl:template>-->


</xsl:stylesheet>