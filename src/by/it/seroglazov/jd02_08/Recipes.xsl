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
                    table.ing_table {
                    border-width: 0;
                    }
                    table.ing_table td {
                    border-width: 0;
                    }
                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/recipes">
        <table>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Tags</th>
                <th>Ingredients</th>
                <th>Description</th>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/recipes/recipe">
        <tr>
            <td><xsl:value-of select="attribute::cocktail_id"/></td>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/recipes/recipe/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/recipes/recipe/tags">
        <td>
            <table class="tagtable">
                <tr>
                    <xsl:apply-templates/>
                </tr>
            </table>
        </td>
    </xsl:template>

    <xsl:template match="/recipes/recipe/tags/tag">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/recipes/recipe/ingredients">
        <td>
            <table class="ing_table">
                <xsl:apply-templates/>
            </table>
        </td>
    </xsl:template>

    <xsl:template match="/recipes/recipe/ingredients/ingredient">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/recipes/recipe/ingredients/ingredient/id">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/recipes/recipe/ingredients/ingredient/amount">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/recipes/recipe/ingredients/ingredient/unit">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/recipes/recipe/ingredients/ingredient/garnish">
        <td>(garnish)</td>
    </xsl:template>

    <xsl:template match="/recipes/recipe/description">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>