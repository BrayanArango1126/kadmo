import Swal, { SweetAlertIcon } from 'sweetalert2';

export const redirectAlert = (icon: SweetAlertIcon, title: string, route: string) => {
  Swal.fire({
    icon: icon,
    title: title,
  }).then(() => {
    window.location.href = `/${route}`;
  });
};

export const infoAlert = (icon: SweetAlertIcon, title: string, text:string) => {
  Swal.fire({
    icon: icon,
    title: title,
    text: text
  })
};

export const redirectActivedAlert = (icon: SweetAlertIcon, title: string, route: string, param:string) => {
  Swal.fire({
    icon: icon,
    title: title,
  }).then(() => {
    window.location.href = `/${route}?redirectUrl=${encodeURIComponent('/store/book/'+encodeURIComponent(param))}`;
  });
};