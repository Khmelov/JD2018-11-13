<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/sale">
        <table border="1">
            <tr>
                <td>
                    data
                </td>
                <td>
                    email_klient
                </td>
                <td>
                    id_tovara
                </td>
                <td>
                    virychka
                </td>

            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/sale/data">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

</xsl:stylesheet>