<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/persons">
        <table border="1">
            <tr><td>email</td><td>nickname</td><td>password</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/persons/person">
        <tr>
            <xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/persons/person/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/persons/person/nickname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/persons/person/password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/persons/person/buys">
        <table border="1">
            <tr><td>item</td><td>id</td><td>specif</td><td>price</td><td>address</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/persons/person/buys/buy">
        <tr>
            <xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/persons/person/buys/buy/item">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/persons/person/buys/buy/id">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/persons/person/buys/buy/specif">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/persons/person/buys/buy/price">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/persons/person/buys/buy/address">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>