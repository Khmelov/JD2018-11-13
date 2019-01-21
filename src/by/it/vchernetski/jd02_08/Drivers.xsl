<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/Drivers">
        <table border="1">
            <tr>
                <td>Name</td>
                <td>NickName</td>
                <td>Email</td>
                <td>Password</td>
                <td>Number of Garages</td>
                <td>Garage(s)'n'Car(s)</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Drivers/driver">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/Drivers/driver/fio">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Drivers/driver/nickname">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Drivers/driver/email">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Drivers/driver/password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Drivers/driver/numbergarages">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/Drivers/driver/garages">
        <td>
            <table>
                <xsl:apply-templates/>
            </table>
        </td>
    </xsl:template>
    <xsl:template match="/Drivers/driver/garages/garage">
        <tr>
        <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/Drivers/driver/garages/garage/adress">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Drivers/driver/garages/garage/carplaces">
        <td>carplace(s)
            <xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Drivers/driver/garages/garage/cars">
        <td>
            <table>
                <xsl:apply-templates/>
            </table>
        </td>
    </xsl:template>
    <xsl:template match="/Drivers/driver/garages/garage/cars/car">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/Drivers/driver/garages/garage/cars/car/model">
        <td>model:
            <xsl:apply-templates/>;
        </td>
    </xsl:template>
    <xsl:template match="/Drivers/driver/garages/garage/cars/car/color">
        <td>color:
            <xsl:apply-templates/>;
        </td>
    </xsl:template>
    <xsl:template match="/Drivers/driver/garages/garage/cars/car/year">
        <td> year:
            <xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>