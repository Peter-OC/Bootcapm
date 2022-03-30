import { LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { environment } from 'src/environments/environment';
import { ERROR_LEVEL, LoggerService, MyCoreModule } from 'src/lib/my-core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainModule } from './main';
import { AuthInterceptor, SecurityModule } from './security';
import { DemosComponent } from './demos/demos.component';
import { CommonServicesModule } from './common-services';
import { DinamicoComponent } from './dinamico/dinamico.component';
import { CalculadoraComponent } from './calculadora/calculadora.component';
import { ContactosModule } from './contactos';
import { FormularioComponent } from './formulario/formulario.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormButtonsComponent } from './common-component/form-buttons/form-buttons.component';
import { AjaxWaitInterceptor } from './main/ajax-wait';
import { BlogModule } from './blog';
import { CommonComponentModule } from './common-component';
import { LibrosModule } from './libros';

@NgModule({
  declarations: [
    AppComponent,
    DemosComponent,
    DinamicoComponent,
    CalculadoraComponent,
    FormularioComponent,
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule,
    AppRoutingModule, MainModule, SecurityModule, MyCoreModule, CommonServicesModule,
    CommonComponentModule, ContactosModule, LibrosModule, BlogModule,
  ],
  providers: [
    LoggerService,
    { provide: ERROR_LEVEL, useValue: environment.ERROR_LEVEL },
    { provide: LOCALE_ID, useValue: 'es-ES'},
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true, },
    { provide: HTTP_INTERCEPTORS, useClass: AjaxWaitInterceptor, multi: true, },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
