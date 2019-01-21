<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html"/>

    <xsl:template match="/users">
        <table border="1">
            <tr><td>email</td><td>nickname</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/users/user">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/users/user/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/nickname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>