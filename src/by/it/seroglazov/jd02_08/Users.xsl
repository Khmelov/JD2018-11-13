<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Users</title>
                <style type="text/css">
                    table {
                    border: 2px solid black;
                    border-collapse: collapse;
                    }
                    th {
                    background-color: lightgrey;
                    border: 1px solid black;
                    }
                    td {
                    border: 1px solid black;
                    padding: 1px 4px;
                    }
                    table.idtable {
                    border-width: 0;
                    border-collapse: separate;
                    }
                    table.idtable td {
                    padding-left: 3px;
                    padding-right: 3px;
                    border: 1px solid grey;
                    }
                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/users">
        <table>
            <tr>
                <th>Nickname</th>
                <th>Email</th>
                <th>Bar</th>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/users/user">
        <tr>
            <td><xsl:value-of select="attribute::nick_name"/></td>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/users/user/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/bar">
        <td>
            <table class="idtable">
                <tr>
                    <xsl:apply-templates/>
                </tr>
            </table>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/bar/id">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

</xsl:stylesheet>