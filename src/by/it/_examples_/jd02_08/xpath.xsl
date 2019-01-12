<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/students">
        <table border="1">
            <tr><td>Name</td><td>NickName</td><td>Phone</td><td>Address</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/students/student">
    <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/students/student/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/students/student/nickname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/students/student/telephone">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/students/student/address">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>