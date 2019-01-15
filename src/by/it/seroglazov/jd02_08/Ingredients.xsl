<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Ingredients</title>
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
                    table.tagtable {
                    border-width: 0;
                    border-collapse: separate;
                    }
                    table.tagtable td {
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

    <xsl:template match="/ingredients">
        <table>
            <tr><th>id</th><th>Name</th><th>Tags</th></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/ingredients/ingredient">
        <tr><td><xsl:value-of select="attribute::id"/></td><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/ingredients/ingredient/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/ingredients/ingredient/tags">
        <td>
            <table class="tagtable">
                <tr>
                    <xsl:apply-templates/>
                </tr>
            </table>
        </td>
    </xsl:template>

    <xsl:template match="/ingredients/ingredient/tags/tag">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>